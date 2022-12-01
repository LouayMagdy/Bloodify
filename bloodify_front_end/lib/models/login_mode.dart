import 'package:bloodify_front_end/models/user.dart';

class UserLoginModel {
  late bool status;
  late String message;
  UserData? data;
  UserLoginModel.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    message = json['message'];
    data = json['data'] != null ? UserData.fromJson(json['data']) : null;
  }
}
