using Microsoft.Extensions.Options;
using MongoDB.Driver;
using WebCluster_AT2_WeatherData_RESTAPI.Settings;

namespace WebCluster_AT2_WeatherData_RESTAPI.Data
{
    public class MongoConnectionBuilder
    {
        // Will hold reference to our connections setttings object
        private readonly IOptions<MongoConnectionSettings> _options;

        // Get connection settings for Mongo
        public MongoConnectionBuilder(IOptions<MongoConnectionSettings> options)
        {
            _options = options;
        }

        public IMongoDatabase GetDatabase()
        {
            var client = new MongoClient(_options.Value.ConnectionString);
            return client.GetDatabase(_options.Value.DatabaseName);
        }
    }
}
