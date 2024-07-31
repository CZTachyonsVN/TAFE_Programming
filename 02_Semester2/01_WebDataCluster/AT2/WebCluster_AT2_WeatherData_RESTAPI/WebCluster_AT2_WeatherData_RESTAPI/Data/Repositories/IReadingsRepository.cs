using WebCluster_AT2_WeatherData_RESTAPI.Models;
using WebCluster_AT2_WeatherData_RESTAPI.Models.DTOs;

namespace WebCluster_AT2_WeatherData_RESTAPI.Data.Repositories
{
    public interface IReadingsRepository
    {
        /// <summary>
        /// Find the maximum precipitation recorded in the last 5 Months for a specific sensor.
        /// </summary>
        /// <returns>Sensor name, reading date / time and the precipitation value</returns>
        MaxPercipitationDTO GetMaxPercipitation(string sensorName);

        /// <summary>
        /// Find reading recorded by a specific station at a given date and time.
        /// </summary>
        /// <returns>Temperature, atmospheric pressure, radiation, and precipitation</returns>
        ReadingByDateTimeDTO GetReadingByDateTime(string sensorName, DateTime time);

        /// <summary>
        /// Find the maximum Temp(C) recorded for all stations for a given Date / Time range (start and finish date) 
        /// </summary>
        /// <returns>Sensor Name, reading date / time and the Temperature value</returns>
        MaxTemperatureDTO GetMaxTemperature(DateTime timeStart, DateTime timeEnd);

        /// <summary>
        /// Update a specified entries’ precipitation value.
        /// </summary>
        void UpdatePercipitation(string sensorName, float precipitationValue);

        /// <summary>
        /// Insert a new reading for a weather station
        /// </summary>
        void AddReading(string sensorName, Reading newReading);

        /// <summary>
        /// Insert multiple sensor readings for single station
        /// </summary>
        void AddBatchReadings(string sensorName,  List<Reading> newBatch);
    }
}
