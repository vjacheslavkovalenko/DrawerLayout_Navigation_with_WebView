package by.vjacheslavkovalenko.drawer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.drawerlayout.widget.DrawerLayout
import by.vjacheslavkovalenko.drawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // binding.xmlWebview.loadUrl("https://icleborobot.by")
        binding.xmlWebView.settings.javaScriptEnabled=true
        binding.xmlWebView.webViewClient = WebViewClient()

        binding.xmlNavigationView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                binding.xmlDrawerLayout.closeDrawers()
                when (item.itemId) {
                    R.id.page_icleborobot -> {
                        binding.xmlWebView.loadUrl("https://icleborobot.by")
                        return true
                    }

                    R.id.icleborobot_aksessuary -> {
                        binding.xmlWebView.loadUrl("https://icleborobot.by/product-category/aksessuary/")
                        return true
                    }

                    R.id.icleborobot_kontakty -> {
                        binding.xmlWebView.loadUrl("https://icleborobot.by/kontakty")
                        return true
                    }

                    else -> return true
                }
            }

        })
    }
}