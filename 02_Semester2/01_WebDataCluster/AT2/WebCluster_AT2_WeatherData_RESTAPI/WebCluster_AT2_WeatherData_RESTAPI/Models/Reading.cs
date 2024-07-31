using MongoDB.Bson.Serialization.Attributes;
using MongoDB.Bson;
using System.Text.Json.Serialization;

namespace WebCluster_AT2_WeatherData_RESTAPI.Models
{
    public class Reading
    {
        [JsonIgnore] //ignore following property
        [BsonId] //following property is primary key
        public ObjectId _id { get; set; }
        public string ObjId => _id.ToString(); //convert ObjectId to string

        [BsonElement("Device Name")]
        public string DeviceName { get; set; } = String.Empty;

        [BsonElement("Precipitation mm/h")]
        public float Percipitation { get; set; }
        public DateTime Time { get; set; }
        public float Latitude { get; set; }
        public float Longitude { get; set; }

        [BsonElement("Temperature (°C)")]
        public float Temperature { get; set; }

        [BsonElement("Atmospheric Pressure (kPa)")]
        public float AtmosphericPressure { get; set; }

        [BsonElement("Solar Radiation (W/m2)")]
        public float SolarRadiation { get; set; }

        [BsonElement("Vapor Pressure (kPa)")]
        public float VaporPressure { get; set; }

        [BsonElement("Humidity (%)")]
        public float Humidity { get; set; }

        [BsonElement("Max Wind Speed (m/s)")]
        public float MaxWindSpeed { get; set; }

        [BsonElement("Wind Direction (°)")]
        public float WindDirection { get; set; }

    }
}
