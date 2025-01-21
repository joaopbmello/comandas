package com.webii.comandas.dto;


public class AddTabItemRequest {
    private Integer tabId;
    private Integer productId;
    private Integer ammount;

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}
