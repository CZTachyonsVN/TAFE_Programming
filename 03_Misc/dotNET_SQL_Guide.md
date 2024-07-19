Download and install required [NuGet packages](../02_Semester2/01_WebDataCluster/01_Notes/NuGetPackagesForDatabaseRESTAPI.md) before proceeding.
# Guide
1. Create `connection string` in `appsettings.json`
```json
{
  "Logging": {
    "LogLevel": {
      "Default": "Information",
      "Microsoft.AspNetCore": "Warning"
    }
  },
  "AllowedHosts": "*",
  "ConnectionStrings": {
    "Default": "Server=localhost; Database=Bookstore2024; Trusted_Connection=true; TrustServerCertificate=true"
  }
}
```
2. Create model classes for objects/database table item
![](../04_Media/Pasted%20image%2020240716040132.png)
3. Create properties for each object/table
```csharp
public class Genre
{
    public int Id { get; set; }
    public string Name { get; set; } = string.Empty;

    // Create a reference to define relationship to the Books table. 1 genre has many books
    public virtual ICollection<Book>? Books { get; set; }
}
```

```csharp
public class Book
{
    public int Id { get; set; }
    public string Title { get; set; } = string.Empty;
    public string Description { get; set; } = string.Empty;
    public double Price { get; set; }
    public int AuthorId { get; set; }
    public int GenreId { get; set; }

    // Create a refrence to define the relationship to the Author and Genre tables.
    // One book as one author and one genre
    public virtual Author? Author { get; set; }
    public virtual Genre? Genre { get; set; }

}
```
4. Create a builder class that defines the objects/tables that are being accessed
```csharp
using Microsoft.EntityFrameworkCore;

namespace BookStore_NVC_SQL.Models.Data
{
    public class BookstoreDB_Context : DbContext
    {
        public BookstoreDB_Context(DbContextOptions options) : base(options) 
        { 
            
        }

        // Declare tables in the database that needs to be accessed.
        public DbSet<Book> Books { get; set; }
        public DbSet<Author> Authors { get; set; }
        public DbSet<Genre> Genres { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            // Populating database with data
            builder.Entity<Author>().HasData(
                new Author { Id=1, FirstName="Liu", LastName="Cixin"},
                new Author { Id = 2, FirstName = "Franz", LastName = "Kafka" },
                new Author { Id = 3, FirstName = "Fyodor", LastName = "Dostoevsky" }
                );

            builder.Entity<Genre>().HasData(
                new Genre { Id = 1, Name = "Fantasy"},
                new Genre { Id = 2, Name = "Sci-fi" },
                new Genre { Id = 3, Name = "Biography" },
                new Genre { Id = 4, Name = "Horror" },
                new Genre { Id = 5, Name = "Romance" },
                new Genre { Id = 6, Name = "Thriller" }
                );

            builder.Entity<Book>().HasData(
                new Book { 
                           Id = 1,
                           Title = "Three Body Problem",
                           Description = "Set against the backdrop of China's Cultural Revolution, a secret military project sends signals into space to establish contact with aliens. An alien civilization on the brink of destruction captures the signal and plans to invade Earth. Meanwhile, on Earth, different camps start forming, planning to either welcome the superior beings and help them take over a world seen as corrupt, or to fight against the invasion.",
                           Price = 35.99,
                           AuthorId = 1,
                           GenreId = 2
                         },
                new Book
                        {
                            Id = 2,
                            Title = "The Metamorphosis",
                            Description = " The Metamorphosis tells the story of salesman Gregor Samsa, who wakes one morning to find himself inexplicably transformed into a huge insect and struggles to adjust to this condition.",
                            Price = 10.50,
                            AuthorId = 2,
                            GenreId = 6
                        },
                new Book
                {
                    Id = 3,
                    Title = "Crime and Punishment",
                    Description = "Crime and Punishment follows the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who plans to kill an unscrupulous pawnbroker, an old woman who stores money and valuable objects in her flat. He theorises that with the money he could liberate himself from poverty and go on to perform great deeds, and seeks to convince himself that certain crimes are justifiable if they are committed in order to remove obstacles to the higher goals of 'extraordinary' men.",
                    Price = 10.50,
                    AuthorId = 3,
                    GenreId = 6
                }

                );
        }
    }
}
```
5. Access the `connection string` from `Program.cs`
```csharp
using BookStore_NVC_SQL.Models.Data;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

var connectionString = builder.Configuration.GetConnectionString("Default");
builder.Services.AddDbContext<BookstoreDB_Context>(options =>
{
    options.UseSqlServer(connectionString); //Annonymous object
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();

```
6. Open NuGet console
![](../04_Media/Pasted%20image%2020240716041351.png)
7. Create migration from console
```shell
add-migration 'migration_name'
```
8. Create database from console
```shell
update-database
```