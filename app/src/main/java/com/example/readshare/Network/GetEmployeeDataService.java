package com.example.readshare.Network;

import com.example.readshare.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEmployeeDataService {
    @GET("emp")
    Call<List<Employee>> getEmployeeData();
}
