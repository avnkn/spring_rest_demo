INSERT INTO Contact (`ID`, `NAME`) VALUES
  (1, 'Oleg'),
  (2, 'Oliver'),
  (3, 'Stanislav'),
  (4, 'Victor'),
  (5, 'Peter');

INSERT INTO Application (`ID`, `CONTACT_ID`, `DT_CREATED`, `PRODUCT_NAME`) VALUES
  (1, 1, '2020-10-04 09:01:01.69', 'Debit card'),
  (2, 1, '2020-10-03 09:01:01.69', 'Deposit'),
  (3, 2, '2020-10-01 09:01:01.69', 'Debit card'),
  (4, 2, '2020-10-02 09:01:01.69', 'Mortgage'),
  (5, 3, '2020-10-01 09:01:01.69', 'Debit card'),
  (6, 4, '2020-09-29 09:01:01.69', 'Deposit');
