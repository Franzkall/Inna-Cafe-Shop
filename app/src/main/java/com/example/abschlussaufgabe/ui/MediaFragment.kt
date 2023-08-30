package com.example.abschlussaufgabe.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.databinding.FragmentMediaBinding

/**
 * Dieses Fragment zeigt die Social-Media-Seiten der Anwendung an.
 */
class MediaFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding : FragmentMediaBinding

    /**
     * Wird aufgerufen, wenn die View für das Fragment erstellt wird.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_media, container, false)
        return binding.root
    }

    /**
     * Wird aufgerufen, nachdem die View des Fragments erstellt wurde.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar-Titel wird aktualisiert
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Socials"

        // Klick-Listener für TikTok-Button
        binding.button.setOnClickListener {
            openUrl("https://www.tiktok.com/@lavazza_cafe_shop_moers")
        }

        // Klick-Listener für Instagram-Button
        binding.button2.setOnClickListener {
            openUrl("https://instagram.com/lavazza_cafe_shop_moers")
        }
    }

    /**
     * Öffnet eine URL in einem Webbrowser.
     */
    private fun openUrl(link: String) {
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("MediaFragment", "Fehler beim Starten der Aktivität: ${e.message}")
        }
    }
}
