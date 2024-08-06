#dapper #sql #wpf #dotnet #csharp 
## Create a configuration file
1. In `Solution Explorer`, right click on the namespace that will be receiving the data 
2. Add > New Item...<br>
![Pasted image 20240322031157.png](../../../04_Media/Pasted%20image%2020240322031157.png)
3. In the pop-up window, select `Application Configuration File` and name it. Make sure it is for C#. This will create a configuration file for the WPF application.<br>
![Pasted image 20240322031307.png](../../../04_Media/Pasted%20image%2020240322031307.png)
## Set up configuration file
1. Open your configuration file from `Solution Explorer`<br>
   ![Pasted image 20240322031439.png](../../../04_Media/Pasted%20image%2020240322031439.png)
2. Inside \<configuration> tags add following lines:<br>
```xml
<connectionStrings>
  <add name="NameOfDatabase" providerName="System.Data.SQLClient"
       connectionString="Data Source=SQLServerName; Integrated Security=True; TrustServerCertificate=True; Initial Catalog=NameOfDatabase" />
</connectionStrings>
```
- `name="NameOfDatabase"` is the name of the database you want to access. To use a database server that is hosted on the same machine, use: `LOCALHOST`
	- Replace `NameOfDatabase` this with the name of your database.
- `providerName="System.Data.SQLClient"` is the name of the package that creates an SQL client for the app. It has not been installed yet.
- `connectionString` contains a set of arguments for the SQL client itself.
	-  `Data Source` put the name of the server you want to access here
	- `Integrated Security=True` allows WPF to access the database without needing username and password. It will use windows authentication instead. Only if the SQL server is also hosted on the same machine as the application.
	- `TrustServerCertificate=True` By default WPF will not access an untrusted SQL server. The server needs a certificate WPF trusts. `True` argument will override that behaviour.
	- `Initial Catalog` is the name of the database you want to access

    ![Pasted image 20240322031542.png](../../../04_Media/Pasted%20image%2020240322031542.png)
## Open NuGet Package Manager
Tools > NuGet Package Manager > Manage NuGet Packages for Solution<br>![Pasted image 20240322031348.png](../../../04_Media/Pasted%20image%2020240322031348.png)
## Install ConfigurationManager Package
Browse NuGet Package Manager > Find `System.Configuration.ConfigurationManager` > Install it to your WPF project.<br>
![Pasted image 20240322032649.png](../../../04_Media/Pasted%20image%2020240322032649.png)
## Create a Library to Handle SQL Connection and Data Transfer
1. In the `Solution Manager` right-click on your solution and add a new project.<br>![Pasted image 20240322032834.png](../../../04_Media/Pasted%20image%2020240322032834.png)
3. Select `WPF Class Library` and name it accordingly (e.g., DataManager) <br>![Pasted image 20240322032931.png](../../../04_Media/Pasted%20image%2020240322032931.png)
## Create a Reference to the Library in the WPF App
![Pasted image 20240322034236.png](../../../04_Media/Pasted%20image%2020240322034236.png)
![Pasted image 20240322034305.png](../../../04_Media/Pasted%20image%2020240322034305.png)<br>
Your `Solution Explorer` should look something like this:<br>
![Pasted image 20240322035041.png](../../../04_Media/Pasted%20image%2020240322035041.png)
## Install SqlClient
Install it to both the WPF project and library<br>
![Pasted image 20240322035149.png](../../../04_Media/Pasted%20image%2020240322035149.png)
## Create SQL Connection Class
Create a new C# class in the `DataManagement` library:
```c#
using Microsoft.Data.SqlClient;
using System.Configuration;

namespace DataManagement
{
    /// <summary>
    /// Helper class connects to a database that is defined in the configuration file.
    /// 
    /// A static class cannont be instantiated as an object from a different class.
    /// The class exists as a single object in the entire project.
    /// </summary>
    public static class Helper
    {
        /// <summary>
        /// Looks for a specific connection string in the application configuration file.
        /// </summary>
        /// <param name="name">The name of a specific connection string that needs to be accessed.</param>
        /// <returns>Returns a set of arguments for the SQL client that is defined in the applicatoin configuration file.</returns>
        private static string GetConnectionString(string name)
        {
            return ConfigurationManager.ConnectionStrings[name].ConnectionString;
        }

        /// <summary>
        /// Establishes an SQL connection.
        /// </summary>
        /// <returns></returns>
        public static SqlConnection SqlConnection()
        {
            return new SqlConnection(GetConnectionString("myNewdb"));
        }
    }
}
```
## Create Data Model Class to transfer database data to C\#
Similarly to a class that was used to store data from a CSV file, we need one that stores data of each column from the database. Make sure the name and datatype of `Properties` also match (case insensitive) the columns in the table that it is derived from otherwise the data will not transfer properly and `Properties` with incorrect name and/or datatype will remain null.<br>
![Pasted image 20240322064108.png](../../../04_Media/Pasted%20image%2020240322064108.png)<br>
```C#
namespace DataManagement
{
    public class Team
    {
        public int Id { get; set; }
        public string Team_name { get; set; }
        public string Contact_name { get; set; }
        public int Phone { get; set; }
        public string Email { get; set; }
        public int Points { get; set; }
    }
}
```

## Install Dapper
Install Dapper package to the library.<br>
![Pasted image 20240322063335.png](../../../04_Media/Pasted%20image%2020240322063335.png)

## Create Data Adapter Class for handling SQL Queries
In this class, you can add more methods to send specific queries to the SQL server
```C#
using Dapper;

namespace DataManagement
{
    /// <summary>
    /// This class handles queries between the application and SQL server.
    /// </summary>
    public static class Adapter
    {
        /// <summary>
        /// Gets all rows and columns from the Teams table.
        /// </summary>
        /// <returns>Returns an entire list of teams.</returns>
        public static List<Team> GetAllTeams()
        {
            string sql = "SELECT * FROM Teams";
            using (var connection = Helper.SqlConnection())
            {
                return connection.Query<Team>(sql).ToList();
            }
        }
    }
}
```

## Access database data in the WPF App
In your `Main Form.xaml.cs` file, create a list for the data class that we created in this guide(`Team` in my case).
```C#
List<Team> myDatabaseTeams = new List<Team>();
```
Add a method that populates the new list.
```C#
/// <summary>
/// Recieve data from the database into the current working list of teams
/// </summary>
private void GetTeamsFromDatabase()
{
    myDatabaseTeams = Adapter.GetAllTeams();
}
```
### Testing
Lets see if you have successfully implemented an SQL connection!
1. Evoke the previous method in the class constructor.
```C#
public YourMainWindow()
{
	InitializeComponent();
	GetTeamsFromDatabase();
}
```
2. Set a debug break point on the closing bracket of the method that populates the new list.<br>
![Pasted image 20240322070511.png](../../../04_Media/Pasted%20image%2020240322070511.png)<br>
3. Start debugging. The program will stop at the break point.
4. If you do not have a Locals window in your Visual Studio, open it: <br> ![Pasted image 20240322071101.png](../../../04_Media/Pasted%20image%2020240322071101.png)
5. Find your new list of teams in the Locals window and expand it to look at the individual variables. The data stored in the list should match the data in your database table.<br>![Pasted image 20240322071410.png](../../../04_Media/Pasted%20image%2020240322071410.png)<br>![Pasted image 20240322071432.png](../../../04_Media/Pasted%20image%2020240322071432.png)
