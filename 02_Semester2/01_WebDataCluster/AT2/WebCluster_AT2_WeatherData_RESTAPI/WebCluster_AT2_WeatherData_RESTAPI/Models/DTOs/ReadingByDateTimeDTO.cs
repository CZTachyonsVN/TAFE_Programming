using MongoDB.Bson.Serialization.Attributes;

namespace WebCluster_AT2_WeatherData_RESTAPI.Models.DTOs
{
    public class ReadingByDateTimeDTO
    {
        [BsonElement("Precipitation mm/h")]
        public float Percipitation { get; set; }

        [BsonElement("Temperature (°C)")]
        public float Temperature { get; set; }

        [BsonElement("Atmospheric Pressure (kPa)")]
        public float AtmosphericPressure { get; set; }

        [BsonElement("Solar Radiation (W/m2)")]
        public float SolarRadiation { get; set; }
    }
}
