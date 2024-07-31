using MongoDB.Driver;
using WebCluster_AT2_WeatherData_RESTAPI.Models;
using WebCluster_AT2_WeatherData_RESTAPI.Models.DTOs;

namespace WebCluster_AT2_WeatherData_RESTAPI.Data.Repositories
{
    public class ReadingsRepository :IReadingsRepository
    {
        // Create a readonly variable to store a reference to MongoDB collection
        private readonly IMongoCollection<Reading> _readings;

        // Get Notes collection from the connected database
        public ReadingsRepository(MongoConnectionBuilder connection)
        {
            _readings = connection.GetDatabase().GetCollection<Reading>("Notes");
        }

        public void AddBatchReadings(string sensorName, List<Reading> newBatch)
        {
            throw new NotImplementedException();
        }

        public void AddReading(string sensorName, Reading newReading)
        {
            throw new NotImplementedException();
        }

        public MaxPercipitationDTO GetMaxPercipitation(string sensorName)
        {
            throw new NotImplementedException();
        }

        public MaxTemperatureDTO GetMaxTemperature(DateTime timeStart, DateTime timeEnd)
        {
            throw new NotImplementedException();
        }

        public ReadingByDateTimeDTO GetReadingByDateTime(string sensorName, DateTime time)
        {
            throw new NotImplementedException();
        }

        public void UpdatePercipitation(string sensorName, float precipitationValue)
        {
            throw new NotImplementedException();
        }
    }
}
