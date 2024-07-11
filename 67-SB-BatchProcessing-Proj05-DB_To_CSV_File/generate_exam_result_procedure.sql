CREATE DEFINER=`root`@`localhost` PROCEDURE `generate_exam_result`()
begin
  declare i int default 0;
  while (i<500000) do
   insert into exam_result(dob,percentage,semester) values ( from_unixtime(unix_timestamp('2000-01-01 01:00:00')+floor(rand()*31536000)),round(rand()*100,2),1);
   set i=i+1;
   end while;
   end