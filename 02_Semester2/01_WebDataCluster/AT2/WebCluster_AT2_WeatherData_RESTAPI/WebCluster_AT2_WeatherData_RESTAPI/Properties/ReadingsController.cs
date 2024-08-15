using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebCluster_AT2_WeatherData_RESTAPI.Properties
{
    [Route("api/[controller]")]
    [ApiController]
    public class ReadingsController : ControllerBase
    {

        // TODO: New Reading for a sensor
        // TODO: Add multiple readings for a sensor
        // TODO: Create new user account
        // TODO: Find maximum precipitation recorded in the last 5 Months for a specific sensor, returning the sensor name, reading date / time and the precipitation value 
        // TODO: Find the temperature, atmospheric pressure, radiation, and precipitation recorded by a specific sensor at a given date and time
        // TODO: Find the maximum Temp(C) recorded for all stations for a given Date / Time range (start and finish date) returning the Sensor Name, reading date / time and the Temperature value
        // TODO: Delete a user by ID
        // TODO: Administrators can remove a range of created user accounts based on a date range
        // TODO: Admin users can correct errors in the dataset
        // TODO: Administrators can upgrade or downgrade multiple users that were created in batches (upgrading or downgrading an entire group of students)

        // GET: api/<ReadingsController>
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/<ReadingsController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<ReadingsController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<ReadingsController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<ReadingsController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
