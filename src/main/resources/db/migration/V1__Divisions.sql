CREATE TABLE divisions(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
	parent_id INT,
    foreign key (parent_id) references divisions(id)
);