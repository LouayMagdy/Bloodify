import 'package:equatable/equatable.dart';

class FoundInstitution extends Equatable {
  late int institutionId;
  late String institutionName;
  late String institutionLocation;
  late double longitude;
  late double latitude;
  late Map<String, int> types_bags;
  late int working_hours;
  late double? distance;

  FoundInstitution(
      {required this.institutionId,
      required this.institutionName,
      required this.institutionLocation,
      required this.longitude,
      required this.latitude,
      required this.types_bags,
      required this.working_hours,
      this.distance});

  @override
  List<Object?> get props => [
        institutionId,
        institutionName,
        institutionName,
        longitude,
        latitude,
        types_bags,
        working_hours
      ];
}

class FoundInstitutionWithDistance extends Equatable {
  final FoundInstitution institution;
  final double distance;
  const FoundInstitutionWithDistance(
      {required this.institution, required this.distance});

  @override
  List<Object?> get props => [institution, distance];
}

class InstitutionBrief extends Equatable {
  final int institutionID;
  final String name, location;
  const InstitutionBrief(
      {required this.institutionID,
      required this.name,
      required this.location});

  @override
  String toString() {
    return '$name, $location';
  }

  @override
  List<Object?> get props => [institutionID, name, location];
}
