namespace WebCluster_AT2_WeatherData_RESTAPI.Data
{
    public enum Roles
    {
        teacher,
        student,
        sensor
    }

    public static class RoleCheck
    {
        public static bool IsTeacher(Roles role)
        {
            return role == Roles.teacher ? true : false; 
        }

        public static bool IsStudent(Roles role)
        {
            return role == Roles.student ? true : false;
        }

        public static bool IsSensor(Roles role)
        {
            return role == Roles.sensor ? true : false;
        }
    }
}
