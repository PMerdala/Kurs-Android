package pl.pmerdala.kursandroid.feature.login

import pl.pmerdala.kursandroid.feature.commons.BaseContract

class LoginContract:BaseContract {
    interface View {
        fun showMessage(message: String)
    }

    interface Presenter:BaseContract.Presenter
    interface Router {
        fun finish()
    }
}