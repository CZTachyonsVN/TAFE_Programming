using TypicalTechTools.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace TypicalTools.Controllers
{
    public class AdminController : Controller
    {
        public IActionResult AdminLogin()
        {
            return View();
        }

        [HttpPost]
        public IActionResult AdminLogin(AdminUser user)
        {
            if (user.Password.Equals("SecurePassword123"))
            {
                HttpContext.Session.SetString("Authenticated", "True");
            }
            return RedirectToAction("Index", "Product");

        }
    }
}
