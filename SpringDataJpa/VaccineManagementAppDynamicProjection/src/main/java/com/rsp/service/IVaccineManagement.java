package com.rsp.service;


import com.rsp.view.View;

import java.util.List;

public interface IVaccineManagement {

    public <T extends View>List<T> fetchByCompany(String company, Class<T> cls);

}
