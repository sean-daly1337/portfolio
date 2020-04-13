using System;
using System.Collections.Generic;

namespace The_book_shop.Comparison
{
    public class CompareBookIsbn : IComparer<Book>
    {
        public int Compare(Book x, Book y)
        {
            return String.CompareOrdinal(x.Isbn, y.Isbn);
        }
    }
}