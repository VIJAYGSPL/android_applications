package com.example.vijay.roomdatabaseexample;

public class EmpDetails {

    int _id;
    String _name;
    String _role;
    String _organization;

    public EmpDetails(int _id,String _name, String _role, String _organization) {
        this._id = _id;
        this._name = _name;
        this._role = _role;
        this._organization = _organization;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_role() {
        return _role;
    }

    public void set_role(String _role) {
        this._role = _role;
    }

    public String get_organization() {
        return _organization;
    }

    public void set_organization(String _organization) {
        this._organization = _organization;
    }
}
