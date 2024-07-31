using System.ComponentModel.DataAnnotations;

namespace TypicalTechTools.Models
{
    public class Comment
    {

        public int Id { get; set; }

        [Display(Name = "Comment")]
        public string CommentText { get; set; } = string.Empty;

        [Display(Name = "Product Code")]
        public int ProductCode { get; set; }

        /// <summary>
        /// Return a CSV formatted string of the a comment object
        /// </summary>
        /// <returns></returns>
        public string ToCSVString()
        {
            return $"{Id},{CommentText},{ProductCode}";
        }

    }
}
