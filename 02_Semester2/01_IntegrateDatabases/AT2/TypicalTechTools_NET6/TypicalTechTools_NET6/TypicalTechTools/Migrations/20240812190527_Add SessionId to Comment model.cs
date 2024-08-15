using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TypicalTechTools.Migrations
{
    /// <inheritdoc />
    public partial class AddSessionIdtoCommentmodel : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Comments",
                keyColumn: "Id",
                keyValue: 1);

            migrationBuilder.AddColumn<string>(
                name: "SessionId",
                table: "Comments",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.UpdateData(
                table: "Comments",
                keyColumn: "Id",
                keyValue: 2,
                column: "SessionId",
                value: null);

            migrationBuilder.UpdateData(
                table: "Comments",
                keyColumn: "Id",
                keyValue: 3,
                column: "SessionId",
                value: null);

            migrationBuilder.UpdateData(
                table: "Comments",
                keyColumn: "Id",
                keyValue: 4,
                column: "SessionId",
                value: null);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "SessionId",
                table: "Comments");

            migrationBuilder.InsertData(
                table: "Comments",
                columns: new[] { "Id", "CommentText", "ProductCode" },
                values: new object[] { 1, "This is a great product. Highly Recommended.", 12345 });
        }
    }
}
