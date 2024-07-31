using TypicalTechTools.DataAccess;
using TypicalTechTools.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using TypicalTechTools.Models.Data;
using TypicalTechTools.Models.Repository;

namespace TypicalTools.Controllers
{
    public class ProductController : Controller
    {
        private readonly IProductRepository _productRepository;

        public ProductController(IProductRepository productRepo)
        {
            _productRepository = productRepo;
        }

        // Show all products
        public IActionResult Index()
        {
            var products = _productRepository.GetAllProucts();
            return View(products);
        }


        public IActionResult Privacy()
        {
            return View();
        }
    }
}
