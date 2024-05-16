package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

public interface OutputFrame {
    JSONObject Output(College college);
}
