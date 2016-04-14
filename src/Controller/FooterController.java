package controller;


import view.FooterView;

public class FooterController {
    FooterView footerView;

    public FooterController(FooterView footerView) {
        this.footerView = footerView;
    }

    public FooterView getFooterView() {
        return footerView;
    }

    public void setFooterView(FooterView footerView) {
        this.footerView = footerView;
    }
}
