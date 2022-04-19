package de.kai_morich.usb_terminal.utils;

import android.Manifest;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

public class PermissionManager {

    public static void askWritePermission(PermissionListener listener) {
        TedPermission.create()
                .setDeniedMessage("Export functionality will not be working properly without this permission\n\nPlease turn on permission from Settings.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .setPermissionListener(listener)
                .check();
    }
}
