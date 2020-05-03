package bsturk.Models;

import bsturk.utils.CreateDriverUtil;

import java.util.ArrayList;

public class TestParameter {
    private CreateDriverUtil.WebDriverType browser;
    private String email, password;
    private int productCount;
    private ArrayList<String> productList;

    public TestParameter() {
        this.productList = new ArrayList<>();
    }

    public CreateDriverUtil.WebDriverType getBrowser() {
        return browser;
    }

    public void setBrowser(CreateDriverUtil.WebDriverType browser) {
        this.browser = browser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addSearchItem(String item) {
        this.productList.add(item);
    }

    public ArrayList<String> getProductList() {
        return productList;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setProductList(ArrayList<String> productList) {
        this.productList = productList;
    }
}
