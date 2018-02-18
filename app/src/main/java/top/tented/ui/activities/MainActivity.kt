package top.tented.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

/**
 * Created by Hoshino Tented on 2017/11/5.
 */

class MainActivity : AppCompatActivity() {
    private fun makeLayout() =
            relativeLayout {
                verticalLayout {
                    textView("This is a text view")
                    button("No touch me!") {
                        setOnClickListener {
                            alert {
                                title = "No!!!"
                                message = "DO NOT TOUCH ME!"
                                isCancelable = false

                                positiveButton("OK") {
                                    this@button.isEnabled = false
                                }
                            }.show()
                        }
                    }
                }.lparams {
                    centerHorizontally()
                    centerVertically()
                }
            }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        makeLayout()
    }
}
