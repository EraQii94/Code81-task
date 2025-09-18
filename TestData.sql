use librarydb

-- Insert test data

-- authors
insert INTO author (name) VALUES
('J.K. Rowling'),
('George R.R. Martin'),
('J.R.R. Tolkien'),
('Agatha Christie');

-- publishers
INSERT INTO publisher (name, address, phone_number) VALUES
('Bloomsbury', '50 Bedford Square, London', '+44 20 7631 5600'),
('Bantam Books', '1745 Broadway, New York', '+1 212-782-9000'),
('HarperCollins', '195 Broadway, New York', '+1 212-207-7000');

-- categories
INSERT INTO category (name) VALUES
('Fantasy'),
('Mystery'),
('Adventure'),
('Science Fiction');

-- members
INSERT INTO member (first_name, last_name, email, address, membership_date, phone_number) VALUES
('Ali', 'Ahmed', 'ali.ahmed@example.com', 'Cairo, Egypt', '2023-01-10', '+201234567890'),
('Sara', 'Mahmoud', 'sara.mahmoud@example.com', 'Giza, Egypt', '2023-03-15', '+201098765432'),
('Omar', 'Hassan', 'omar.hassan@example.com', 'Alexandria, Egypt', '2024-02-20', '+201223344556');


-- books

INSERT INTO book (isbn, available_copies, cover_image_url, edition, language, publication_year, status, summary, title, total_copies, publisher_id)
VALUES
('9780747532743', 5, 'https://example.com/hp1.jpg', '1st', 'English', 1997, 'AVAILABLE', 'A young wizard begins his journey.', 'Harry Potter and the Philosopher''s Stone', 5, 1),
('9780553103540', 3, 'https://example.com/got1.jpg', '1st', 'English', 1996, 'AVAILABLE', 'Noble families fight for control of the Iron Throne.', 'A Game of Thrones', 4, 2),
('9780261103573', 2, 'https://example.com/lotr1.jpg', '2nd', 'English', 1954, 'AVAILABLE', 'Hobbits embark on a quest to destroy the One Ring.', 'The Fellowship of the Ring', 3, 3),
('9780007120840', 4, 'https://example.com/poirot.jpg', '1st', 'English', 1920, 'AVAILABLE', 'Detective Hercule Poirot solves mysteries.', 'The Mysterious Affair at Styles', 4, 3);



-- book_authors
INSERT INTO book_authors (book_isbn, author_id) VALUES
('9780747532743', 1),
('9780553103540', 2),
('9780261103573', 3),
('9780007120840', 4);

-- book_categories
INSERT INTO book_categories (book_isbn, category_id) VALUES
('9780747532743', 1),
('9780553103540', 1),
('9780261103573', 3),
('9780007120840', 2);

-- borrowing_transactions
INSERT INTO borrowing_transaction (borrow_date, due_date, return_date, book_isbn, member_id) VALUES
('2024-05-01', '2024-05-15', '2024-05-12', '9780747532743', 1),
('2024-05-10', '2024-05-24', '2024-05-17', '9780553103540', 2),
('2024-06-01', '2024-06-15', '2024-06-14', '9780261103573', 3);




select * from book