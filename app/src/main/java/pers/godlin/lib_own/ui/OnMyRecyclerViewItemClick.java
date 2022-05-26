package pers.godlin.lib_own.ui;

import android.view.View;

/**
 * @author: gentlemanhu
 * @date: 2022/5/13
 */
public interface OnMyRecyclerViewItemClick<DT> {
    void onClick(View view,DT data);
}
