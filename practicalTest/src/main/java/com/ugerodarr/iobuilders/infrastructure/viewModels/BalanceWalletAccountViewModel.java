package com.ugerodarr.iobuilders.infrastructure.viewModels;

import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;

import java.util.List;

public class BalanceWalletAccountViewModel {

    public Float total;
    public List<WalletActivity> listWalletActivity;

    public BalanceWalletAccountViewModel() {
    }

    public BalanceWalletAccountViewModel(Float total, List<WalletActivity> listWalletActivity) {
        this.total = total;
        this.listWalletActivity = listWalletActivity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<WalletActivity> getListWalletActivity() {
        return listWalletActivity;
    }

    public void setListWalletActivity(List<WalletActivity> listWalletActivity) {
        this.listWalletActivity = listWalletActivity;
    }
}
