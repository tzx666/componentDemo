package buct.tzx.componentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import buct.tzx.routerannotation.Router
import buct.tzx.routerapi.BuctRouter

@Router(Path = "/main/home")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var containerview = findViewById<View>(R.id.fragment_view)
        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var fragment = BuctRouter.getInstance().naviagtion(this,"/main/feed") as Fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, fragment).commit()
    }
}