using TypicalTechTools.DataAccess;
using TypicalTechTools.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace TypicalTools.Controllers
{
    public class CommentController : Controller
    {
        CsvParser _csvParser;

        public CommentController(CsvParser csvParser)
        {
            _csvParser = csvParser;
        }

        [HttpGet]
        public IActionResult CommentList(int id)
        {
            List<Comment> comments = _csvParser.GetCommentsForProduct(id);

            if(comments == null)
            {
                return RedirectToAction("Index", "Product");
            }

            return View(comments);

        }


        // Show a form to add a new comment
        [HttpGet]
        public IActionResult AddComment(int productCode)
        {
            Comment comment = new Comment();
            comment.ProductCode = productCode;
            return View(comment);
        }

        // Receive and handle the newly created comment data
        [HttpPost]
        public IActionResult AddComment(Comment comment)
        {
            _csvParser.AddComment(comment, HttpContext.Session.Id);

            // A session id is only set once a value has been added!
            // adding a value here to ensure the session is created
            HttpContext.Session.SetString("CommentText", comment.CommentText);

            return RedirectToAction("Index", "Product");
        }

        // Receive and handle a request to Delete a comment
        public IActionResult RemoveComment(int commentId)
        {
            var comment = _csvParser.GetSingleComment(commentId);

            // Check if the admin is logged in
            string authStatus = HttpContext.Session.GetString("Authenticated");
            bool isAdmin = !String.IsNullOrWhiteSpace(authStatus) && authStatus.Equals("True");


            _csvParser.DeleteComment(commentId);
            

            return RedirectToAction("CommentList", "Comment", new {id = comment.ProductCode});
        }

        // Show a existing comment details in a form to allow for editing
        [HttpGet]
        public IActionResult EditComment(int commentId)
        {
            Comment comment = _csvParser.GetSingleComment(commentId);
            return View(comment);
        }

        // Receive and handle the edited comment data
        [HttpPost]
        public IActionResult EditComment(Comment comment)
        {
            if(comment == null)
            {
                return RedirectToAction("Index", "Product");
            }

            // Check if the admin is logged in
            string authStatus = HttpContext.Session.GetString("Authenticated");
            bool isAdmin = !String.IsNullOrWhiteSpace(authStatus) && authStatus.Equals("True");

             _csvParser.EditComment(comment);
            

            

            return RedirectToAction("CommentList", "Comment", new { id = comment.ProductCode });

        }
    }
}
