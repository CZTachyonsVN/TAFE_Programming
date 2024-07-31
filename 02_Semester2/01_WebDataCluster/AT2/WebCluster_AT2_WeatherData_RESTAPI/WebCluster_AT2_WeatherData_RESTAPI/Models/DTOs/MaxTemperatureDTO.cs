﻿using MongoDB.Bson.Serialization.Attributes;

namespace WebCluster_AT2_WeatherData_RESTAPI.Models.DTOs
{
    public class MaxTemperatureDTO
    {
        [BsonElement("Device Name")]
        public string DeviceName { get; set; } = String.Empty;
        public DateTime Time { get; set; }

        [BsonElement("Temperature (°C)")]
        public float Temperature { get; set; }
    }
}