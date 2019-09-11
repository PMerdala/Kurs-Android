package pl.pmerdala.kursandroid.feature.login

import io.reactivex.Observable
import pl.pmerdala.kursandroid.feature.commons.BaseContract

class LoginContract:BaseContract {
    interface View {
        fun showMessage(message: String)
        fun getLoginClickObservable():Observable<Unit>
        fun getUsername():String
    }

    interface Presenter:BaseContract.Presenter
    interface Router {
        fun finish()
        fun navigateToRepositories()
    }
}