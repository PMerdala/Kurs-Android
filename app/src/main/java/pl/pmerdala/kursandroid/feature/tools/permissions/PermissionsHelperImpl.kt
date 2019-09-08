package pl.pmerdala.kursandroid.feature.tools.permissions

import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity

class PermissionsHelperImpl(
    private val activity: BaseActivity
) : PermissionsHelper {
    override fun request(vararg permissions: String): Observable<Boolean> {
        return RxPermissions(activity).request(*permissions)
    }
}