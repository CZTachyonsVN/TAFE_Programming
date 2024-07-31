using Microsoft.SqlServer.Server;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace TypicalTechTools.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string ProductName { get; set; } = string.Empty;
        [Column(TypeName = "decimal(18,5)")]
        public decimal ProductPrice { get; set; }
        public string ProductDescription { get; set; } = string.Empty;
    }
}
