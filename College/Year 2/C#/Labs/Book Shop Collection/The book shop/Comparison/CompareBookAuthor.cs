using System;
using System.Collections.Generic;

namespace The_book_shop.Comparison
{
    public class CompareBookAuthor : IComparer<Book>
    {
        public int Compare(Book x, Book y)
        {
            return String.CompareOrdinal(x.Author, y.Author);
        }
    }
}