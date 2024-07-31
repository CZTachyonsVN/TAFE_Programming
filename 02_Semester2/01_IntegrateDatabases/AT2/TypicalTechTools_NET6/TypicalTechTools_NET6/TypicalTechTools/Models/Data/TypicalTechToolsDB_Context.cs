using Microsoft.EntityFrameworkCore;
using TypicalTechTools.DataAccess;

namespace TypicalTechTools.Models.Data
{
    public class TypicalTechToolsDB_Context : DbContext
    {
        private readonly CsvParser _csvParser;
        public TypicalTechToolsDB_Context(DbContextOptions options, CsvParser parser) : base(options)
        {
            _csvParser = parser;
        }

        public DbSet<Product> Products { get; set; }
        public DbSet<Comment> Comments { get; set; }
        public DbSet<AdminUser> AdminUsers { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            //TODO: implement database creation
            builder.Entity<Product>().HasData(_csvParser.ParseProducts());
            builder.Entity<Comment>().HasData(_csvParser.ParseComments());
        }
    }
}
