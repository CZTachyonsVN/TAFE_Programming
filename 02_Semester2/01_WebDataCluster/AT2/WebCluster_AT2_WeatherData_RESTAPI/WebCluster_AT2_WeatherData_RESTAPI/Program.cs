using WebCluster_AT2_WeatherData_RESTAPI.Data;
using WebCluster_AT2_WeatherData_RESTAPI.Settings;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//MongoDB connection settings
builder.Services.Configure<MongoConnectionSettings>(builder.Configuration.GetSection("ConnectString"));
#region Dependency Injection
builder.Services.AddScoped<MongoConnectionBuilder>();

#endregion

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
