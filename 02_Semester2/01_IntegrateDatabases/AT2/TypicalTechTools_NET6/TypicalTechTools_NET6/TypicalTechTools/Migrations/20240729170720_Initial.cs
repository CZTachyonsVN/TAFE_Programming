using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace TypicalTechTools.Migrations
{
    /// <inheritdoc />
    public partial class Initial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "AdminUsers",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Password = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_AdminUsers", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Comments",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CommentText = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    ProductCode = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Comments", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Products",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    ProductName = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    ProductPrice = table.Column<decimal>(type: "decimal(18,2)", nullable: false),
                    ProductDescription = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Products", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "Comments",
                columns: new[] { "Id", "CommentText", "ProductCode" },
                values: new object[,]
                {
                    { 1, "This is a great product. Highly Recommended.", 12345 },
                    { 2, "Not worth the excessive price. Stick with a cheaper generic one.", 12350 },
                    { 3, "A great budget buy. As good as some of the expensive alternatives.", 12345 },
                    { 4, "Total garbage. Never buying this brand again. ", 12347 }
                });

            migrationBuilder.InsertData(
                table: "Products",
                columns: new[] { "Id", "ProductDescription", "ProductName", "ProductPrice" },
                values: new object[,]
                {
                    { 12345, " bluetooth headphones with fair battery life and a 1 month warranty", " Generic Headphones", 84.99m },
                    { 12346, " bluetooth headphones with good battery life and a 6 month warranty", " Expensive Headphones", 149.99m },
                    { 12347, " bluetooth headphones with good battery life and a 12 month warranty", " Name Brand Headphones", 199.99m },
                    { 12348, " simple bluetooth pointing device", " Generic Wireless Mouse", 39.99m },
                    { 12349, " mouse and keyboard wired combination", " Logitach Mouse and Keyboard", 73.99m },
                    { 12350, " quality wireless mouse", " Logitach Wireless Mouse", 149.99m }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "AdminUsers");

            migrationBuilder.DropTable(
                name: "Comments");

            migrationBuilder.DropTable(
                name: "Products");
        }
    }
}
