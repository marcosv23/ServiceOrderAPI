CREATE TABLE service_orders (
  id BIGINT NOT NULL AUTO_INCREMENT UNIQUE, 
  customer_id BIGINT, 
  description TEXT NOT NULL, 
  price decimal(10,2),
  starting_date DATETIME NOT NULL, 
  ending_date DATETIME,
  status VARCHAR(10) NOT NULL DEFAULT 'OPENED', 

  created_at TIMESTAMP DEFAULT  CURRENT_TIMESTAMP, 
  updated_at TIMESTAMP DEFAULT   CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  deleted_at TIMESTAMP NULL DEFAULT NULL,

  PRIMARY KEY(id),
  CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customers(id)
);
