package com.example.abschlussaufgabe.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.abschlussaufgabe.activities.MainActivity
import com.example.abschlussaufgabe.databinding.FragmentRewardBinding

/**
 * Das Fragment für den Belohnungs-Scanner.
 */
class RewardFragment : Fragment() {

    // Binding-Objekt für das Fragment
    private lateinit var binding: FragmentRewardBinding

    // CodeScanner-Objekt für das Scannen von QR-Codes
    private lateinit var codeScanner: CodeScanner

    /**
     * Wird aufgerufen, um die Ansicht für das Fragment zu erstellen.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRewardBinding.inflate(inflater, container, false)

        // Setzt den Titel der Toolbar in der MainActivity
        val activity: MainActivity = requireActivity() as MainActivity
        activity.toolbarTitle.text = "Scanner"

        // Überprüft und fordert ggf. Berechtigungen an
        setUpPermissions()

        // Initialisiert den CodeScanner
        codeScanner()
        return binding.root
    }

    /**
     * Initialisiert den CodeScanner für das Scannen von QR-Codes.
     */
    private fun codeScanner() {
        codeScanner = CodeScanner(requireContext(), binding.scannerView)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            // Callback für das Entschlüsseln des QR-Codes
            decodeCallback = DecodeCallback {
                requireActivity().runOnUiThread {
                    binding.tvText.text = it.text
                }
            }
            // Callback für Fehler beim Initialisieren der Kamera
            errorCallback = ErrorCallback {
                requireActivity().runOnUiThread {
                    Log.e("Main", "Camera initialization errors: ${it.message}")
                }
            }
        }

        // Klick-Listener für den Scanner-Bereich
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    /**
     * Wird aufgerufen, wenn das Fragment wieder in den Vordergrund kommt.
     */
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    /**
     * Wird aufgerufen, wenn das Fragment pausiert wird.
     */
    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    /**
     * Überprüft und fordert die Berechtigungen für die Kamera an.
     */
    private fun setUpPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            requireContext(),
            android.Manifest.permission.CAMERA
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    /**
     * Fordert die Berechtigung für die Kamera an.
     */
    private fun makeRequest() {
        requestPermissions(
            arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }

    /**
     * Wird aufgerufen, wenn eine Berechtigungsanfrage abgeschlossen ist.
     */
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        requireContext(),
                        "You need the camera permission to be able to use this app!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Berechtigung erfolgreich
                }
            }
        }
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 101
    }
}

/**Fachlicher Kommentar:
Dieses Fragment ermöglicht es Benutzern, QR-Codes zu scannen. Es verwendet die CodeScanner-Bibliothek, um die Kamera zu initialisieren und QR-Codes zu decodieren. Benutzer müssen die Kameraberechtigung gewähren, damit diese Funktion ordnungsgemäß funktioniert. Der gescannte QR-Code-Text wird angezeigt, sobald er erkannt wird.*/

