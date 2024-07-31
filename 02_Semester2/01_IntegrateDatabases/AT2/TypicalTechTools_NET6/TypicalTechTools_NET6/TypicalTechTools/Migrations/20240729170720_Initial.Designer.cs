﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using TypicalTechTools.Models.Data;

#nullable disable

namespace TypicalTechTools.Migrations
{
    [DbContext(typeof(TypicalTechToolsDB_Context))]
    [Migration("20240729170720_Initial")]
    partial class Initial
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "8.0.7")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder);

            modelBuilder.Entity("TypicalTechTools.Models.AdminUser", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("Id"));

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("AdminUsers");
                });

            modelBuilder.Entity("TypicalTechTools.Models.Comment", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("Id"));

                    b.Property<string>("CommentText")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<int>("ProductCode")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.ToTable("Comments");

                    b.HasData(
                        new
                        {
                            Id = 1,
                            CommentText = "This is a great product. Highly Recommended.",
                            ProductCode = 12345
                        },
                        new
                        {
                            Id = 2,
                            CommentText = "Not worth the excessive price. Stick with a cheaper generic one.",
                            ProductCode = 12350
                        },
                        new
                        {
                            Id = 3,
                            CommentText = "A great budget buy. As good as some of the expensive alternatives.",
                            ProductCode = 12345
                        },
                        new
                        {
                            Id = 4,
                            CommentText = "Total garbage. Never buying this brand again. ",
                            ProductCode = 12347
                        });
                });

            modelBuilder.Entity("TypicalTechTools.Models.Product", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("Id"));

                    b.Property<string>("ProductDescription")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("ProductName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<decimal>("ProductPrice")
                        .HasColumnType("decimal(18,2)");

                    b.HasKey("Id");

                    b.ToTable("Products");

                    b.HasData(
                        new
                        {
                            Id = 12345,
                            ProductDescription = " bluetooth headphones with fair battery life and a 1 month warranty",
                            ProductName = " Generic Headphones",
                            ProductPrice = 84.99m
                        },
                        new
                        {
                            Id = 12346,
                            ProductDescription = " bluetooth headphones with good battery life and a 6 month warranty",
                            ProductName = " Expensive Headphones",
                            ProductPrice = 149.99m
                        },
                        new
                        {
                            Id = 12347,
                            ProductDescription = " bluetooth headphones with good battery life and a 12 month warranty",
                            ProductName = " Name Brand Headphones",
                            ProductPrice = 199.99m
                        },
                        new
                        {
                            Id = 12348,
                            ProductDescription = " simple bluetooth pointing device",
                            ProductName = " Generic Wireless Mouse",
                            ProductPrice = 39.99m
                        },
                        new
                        {
                            Id = 12349,
                            ProductDescription = " mouse and keyboard wired combination",
                            ProductName = " Logitach Mouse and Keyboard",
                            ProductPrice = 73.99m
                        },
                        new
                        {
                            Id = 12350,
                            ProductDescription = " quality wireless mouse",
                            ProductName = " Logitach Wireless Mouse",
                            ProductPrice = 149.99m
                        });
                });
#pragma warning restore 612, 618
        }
    }
}
