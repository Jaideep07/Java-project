/*CREATE EXTENSION pgcrypto;*/
create table Client (
	id varchar(10),
	fname varchar(20),
	lname varchar(10),
	street_name varchar(20),
	city varchar(20),
	state varchar(20),
	zip_code int,
	passcode varchar(100),
	primary key(id)
);
/*DROP Table Client;
SELECT * from Client WHERE passcode=crypt('abhinav123',passcode);
SELECT * FROM client;*/

insert into Client values('C1','Abhinav','Reddy','Abids','Hyderabad','Telangana',500001,crypt('abhinav123',gen_salt('bf',4))),
					     ('C2','Bhavith','Sharma','Janpath','New Delhi','Delhi',110001,crypt('bhavith123',gen_salt('bf',4))),
					     ('C3','Himanshu','Bhatt','MG Road','Bangalore','Karnataka',560001,crypt('himanshu123',gen_salt('bf',4))),
					     ('C4','Subramaniam','Iyer','Ranganathan Gardens','Chennai','Tamil Nadu',600040,crypt('subramaniam123',gen_salt('bf',4))),
					     ('C5','Shivaji','Deshpande','Peddar Road','Mumbai','Maharashtra',400026,crypt('shivaji123',gen_salt('bf',4)));
						 
create table Builder (
	id varchar(10),
	job_description varchar(20),
	fname varchar(10),
	lname varchar(10),
	street_name varchar(20),
	city varchar(20),
	state varchar(20),
	zip_code int,
	gender char(1) check(gender = 'M' or gender = 'F'),
	salary numeric(8,2),
	supervisor_id varchar(10) references Builder(id),
	email varchar(50),
	phone bigint,
	passcode varchar(100),
	primary key(id)
);


insert into Builder values  ('B1','Architect','Atharv','Sharma',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   80000.00,'B1','atharvsharma@gmail.com',9595959501,crypt('Atharv123',gen_salt('bf',4))),
						   
						   ('B2','Civil Engr','Arun','Varma',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   50000.00,'B1','arunvarma@gmail.com',9595959502,crypt('Arun123',gen_salt('bf',4))),
						   
						   ('B3','Builder','Bhaskar','Reddy',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   110000.00,'B1','bhaskarreddy@gmail.com',9595959503,crypt('Bhaskar123',gen_salt('bf',4))),
						   
						   ('B4','Architect','Bhavesh','Reddy',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   70000.00,'B1','bhaveshreddy@gmail.com',9595959504,crypt('Bhavesh123',gen_salt('bf',4))),
						   
						   ('B5','Civil Engr','David','Muller',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   60000.00,'B5','davidmuller@gmail.com',9595959505,crypt('David123',gen_salt('bf',4))),
						   
						   ('B6','Builder','Dharani','Prasad',
						   'Abids','Hyderabad','Telangana',500001,'F',
						   120000.00,'B5','dharaniprasad@gmail.com',9595959506,crypt('Dharani123',gen_salt('bf',4))),
						   
						   ('B7','Architect','Alekhya','Singh',
						   'Abids','Hyderabad','Telangana',500001,'F',
						   85000.00,'B5','alekhyasingh@gmail.com',9595959507,crypt('Alekhya123',gen_salt('bf',4))),
						   
						   ('B8','Civil Engr','Preethi','Shingh',
						   'Abids','Hyderabad','Telangana',500001,'F',
						   45000.00,'B5','preethisingh@gmail.com',9595959508,crypt('Preethi123',gen_salt('bf',4))),
						   
						   ('B9','Builder','Rohan','Singh',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   110000.00,'B9','rohansingh@gmail.com',9595959509,crypt('Rohan123',gen_salt('bf',4))),
						   
						   ('B10','Architect','John','Abranam',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   80000.00,'B9','johnabraham@gmail.com',9595959510,crypt('John123',gen_salt('bf',4))),
						   
						   ('B11','Civil Engr','Sanchi','Chopra',
						   'Abids','Hyderabad','Telangana',500001,'F',
						   65000.00,'B9','sanchichopra@gmail.com',9595959511,crypt('Sanchi123',gen_salt('bf',4))),
						   
						   ('B12','Builder','Pranav','Reddy',
						   'Abids','Hyderabad','Telangana',500001,'M',
						   100000.00,'B9','pranavreddy@gmail.com',9595959512,crypt('Pranav123',gen_salt('bf',4)));
							
create table Retailer (
	id varchar(10),
	name varchar(20),
	Street_name varchar(20),
	city varchar(20),
	state varchar(20),
	Zip_code int,
	email varchar(80),
	passcode varchar(100),
	service_rating numeric(2,1),
	primary key(id)
);

insert into Retailer values('R1','Abhishek','Abids','Hyderabad','Telangana',500001,'abhishek@gmail.com',crypt('qwe@1244',gen_salt('bf',4)),4.5),
					       ('R2','Bharghav','Janpath','New Delhi','Delhi',110001,'bharghav@gmail.com',crypt('trqw@1342',gen_salt('bf',4)),4.8),
					       ('R3','Hemanth','MG Road','Bangalore','Karnataka',560001,'hemanth@gmail.com',crypt('fgyt$353',gen_salt('bf',4)),4.4),
					       ('R4','Sharath','Ranganathan Gardens','Chennai','Tamil Nadu',600040,'sharath@gmail.com',crypt('asdfe&31',gen_salt('bf',4)),4.7),
					       ('R5','Varun','Peddar Road','Mumbai','Maharashtra',400026,'varun@gmail.com',crypt('gyhd@tyhn',gen_salt('bf',4)),4.9);
						   
create table Client_Emails (
	id varchar(10),
	email varchar(80),
	primary key(id,email),
	foreign key(id) references Client(id)
);

insert into Client_Emails values('C1','AbhinavReddy@gmail.com'),
								('C2','BhavithSharma@gmail.com'),
								('C3','HimanshuBhatt@gmail.com'),
								('C4','SubramaniamIyer@gmail.com'),
								('C5','ShivajiDeshpande@gmail.com');
								

create table Client_phone_numbers (
	id varchar(10),
	phone bigint,
	primary key(id,phone),
	foreign key(id) references Client(id)
);

insert into Client_phone_numbers values('C1',9595959595),
									   ('C2',8181818181),
									   ('C3',9090909090),
									   ('C4',9696969696),
									   ('C5',9191919191);



create table Groups (
	number varchar(10),
	name varchar(10),
	category varchar(10),
	manager_id varchar(10),
	primary key(number),
	foreign key(manager_id) references Builder(id)
);

insert into Groups values('G1','Group1','Commercial','B1'),
						 ('G2','Group2','Office','B4'),
						 ('G3','Group3','Private','B7'),
						 ('G4','Group4','Commercial','B10'),
						 ('G5','Group5','Office','B2'),
						 ('G6','Group6','Private','B6');
						 
create table Retailer_material (
	retailer_id varchar(10),
	material_name varchar(20),
	material_model varchar(20),
	material_type varchar(20),
	manufacturer varchar(20),
	primary key(retailer_id,material_name,material_model),
	foreign key(retailer_id) references Retailer(id)
);

insert into Retailer_material values('R1','Brick Clay','BC-100','Clay','Manufacturer1'),
							 ('R1','Stoneware Clay','SC-100','Clay','Manufacturer2'),
							 ('R1','Earthenware Clay','EC-100','Clay','Manufacturer1'),
							 ('R1','Concrete Sand','CS-100','Sand','Manufacturer3'),
							 ('R1','Natural Sand','NS-100','Sand','Manufacturer3'),
							 ('R2','Granite','GR-100','Rock','Manufacturer5'),
							 ('R2','Sandstone','SR-100','Rock','Manufacturer5'),
							 ('R2','Limestone','LR-100','Rock','Manufacturer6'),
							 ('R2','Oak','OHW-100','Hardwood-Wood','Manufacturer7'),
							 ('R2','Pine','PSW-100','Softwood-Wood','Manufacturer8'),
							 ('R3','Concrete Sand','CS-100','Sand','Manufacturer4'),
							 ('R3','Natural Sand','NS-100','Sand','Manufacturer3'),
							 ('R3','Utility Sand','US-100','Sand','Manufacturer4'),
							 ('R4','Oak','OHW-100','Hardwood-Wood','Manufacturer7'),
							 ('R4','Teak','THW-100','Hardwood-Wood','Manufacturer7'),
							 ('R4','Pine','PSW-100','Softwood-Wood','Manufacturer8'),
							 ('R4','Ash','ASW-100','Softwood-Wood','Manufacturer8'),
							 ('R5','OPC','OPC-100','Cement','Manufacturer9'),
							 ('R5','Sandstone','SR-100','Rock','Manufacturer6'),
							 ('R5','Limestone','LR-100','Rock','Manufacturer5');

create table Project (
	number varchar(10),
	name varchar(20),
	assigned_date date,
	start_date date,
	end_date date,
	tenure int,
	group_number varchar(10),
	primary key(number),
	foreign key(group_number) references Groups(number)
);

insert into Project values('P1','Project1','2018-05-05','2018-06-05','2020-01-05',2,'G1'),
						  ('P2','Project2','2016-05-15','2016-06-15','2021-02-10',2,'G2'),
						  ('P3','Project2','2019-05-25','2019-06-25','2022-02-15',2,'G3'),
						  ('P4','Project2','2018-05-05','2018-06-05','2020-04-20',2,'G4'),
						  ('P5','Project2','2016-05-15','2016-06-15','2021-05-25',2,'G5'),
						  ('P6','Project2','2019-05-25','2019-06-25','2022-06-30',2,'G6'),
						  ('P7','Project2','2019-06-27','2019-07-25','2022-07-25',2,'G6');
						  
create table Site (
	id varchar(10),
	street_name	varchar(20),
	city varchar(20),
	state varchar(20),
	zip_code int,
	site_area_sqyards int,
	site_terrain varchar(20),
	soil_type varchar(20),
	project_no varchar(10),
	client_id varchar(10),
	date_of_purchase date,
	ownership_type varchar(30),
	primary key(id),
	foreign key(client_id) references Client(id),
	foreign key(project_no) references Project(number)
);

insert into Site values('S1','Abids','Hyderabad','Telangana',500001,1500,'Open','Black','P1','C1','2005-10-25','Individual'),
						('S2','Janpath','New Delhi','Delhi',110001,500,'Open','Sandy','P2','C2','2005-10-05', 'Individual'),
						('S3','Janpath','New Delhi','Delhi',110001,1500,'Open','Sandy','P3','C2','2008-12-15' ,'Joint' ),
						('S4','MG Road','Bangalore','Karnataka',560001,600,'Tundra','Sandy','P4','C3','2000-09-05' ,'Individual' ),
						('S5','Ranganathan Gardens','Chennai','Tamil Nadu',600040,600,'Open','Sandy','P5','C4','1995-02-20' ,'Joint'),
						('S6','Peddar Road','Mumbai','Maharashtra',400026,2000,'Open','Mountain','P6','C5','2010-05-05' ,'Individual'),
						('S7','Peddar Road','Mumbai','Maharashtra',400026,2500,'Open','Mountain','P7','C5','2015-06-10' ,'Joint');

create table Raw_materials (
	site_id varchar(10),
	material_name varchar(20),
	material_model varchar(20),
	material_type varchar(20),
	material_quantity int,
	reorder_level int,
	available_quantiy int,
	primary key(site_id,material_name,material_model),
	foreign key(site_id) references Site(id)
);

insert into Raw_materials values('S1','Brick Clay','BC-100','Clay',1000,5000,8000),
								('S1','Granite','GR-100','Rock',1000,500,1500),
								('S1','Concrete Sand','CS-100','Sand',1000,600,2000),
								('S1','Oak','OHW-100','Hardwood-Wood',800,200,1000),
								('S1','OPC','OPC-100','Cement',1000,100,500),
								
								('S2','Stoneware Clay','SC-100','Clay',100,500,800),
								('S2','Sandstone','SR-100','Rock',100,50,150),
								('S2','Natural Sand','NS-100','Sand',100,60,200),
								('S2','Teak','THW-100','Hardwood-Wood',80,20,100),
								('S2','OPC','OPC-100','Cement',100,10,50),
								
								('S3','Earthenware Clay','EC-100','Clay',1000,5000,8000),
								('S3','Limestone','LR-100','Rock',1000,500,1500),
								('S3','Utility Sand','US-100','Sand',1000,600,2000),
								('S3','Pine','PSW-100','Softwood-Wood',800,200,1000),
								('S3','OPC','OPC-100','Cement',1000,100,500),
								
								('S4','Brick Clay','BC-100','Clay',100,500,800),
								('S4','Granite','GR-100','Rock',100,50,150),
								('S4','Concrete Sand','CS-100','Sand',100,60,200),
								('S4','Ash','ASW-100','Softwood-Wood',80,20,100),
								('S4','OPC','OPC-100','Cement',100,10,50),
								
								('S5','Stoneware Clay','SC-100','Clay',100,500,800),
								('S5','Sandstone','SR-100','Rock',100,50,150),
								('S5','Natural Sand','NS-100','Sand',100,60,200),
								('S5','Oak','OHW-100','Hardwood-Wood',80,20,100),
								('S5','OPC','OPC-100','Cement',100,10,50),
								
								('S6','Earthenware Clay','EC-100','Clay',1000,5000,8000),
								('S6','Limestone','LR-100','Rock',1000,500,1500),
								('S6','Utility Sand','US-100','Sand',1000,600,2000),
								('S6','Teak','THW-100','Hardwood-Wood',800,200,1000),
								('S6','OPC','OPC-100','Cement',1000,100,500),
								
								('S7','Brick Clay','BC-100','Clay',1000,5000,8000),
								('S7','Granite','GR-100','Rock',1000,500,1500),
								('S7','Concrete Sand','CS-100','Sand',1000,600,2000),
								('S7','Pine','PSW-100','Softwood-Wood',800,200,1000),
								('S7','OPC','OPC-100','Cement',1000,100,500);

create table Supplies (
	retailer_id varchar(10),
	site_id	varchar(10),
	material_model varchar(20),
	material_name varchar(20),
	primary key(site_id,material_model,material_name),
	foreign key(retailer_id) references Retailer(id),
	foreign key(site_id,material_name,material_model) references Raw_materials(site_id,material_name,material_model)
);

insert into Supplies values('R1','S1','BC-100','Brick Clay'),
						   ('R2','S1','GR-100','Granite'),
						   ('R1','S1','CS-100','Concrete Sand'),
						   ('R4','S1','OHW-100','Oak'),
						   ('R5','S1','OPC-100','OPC'),
						   
						   ('R1','S2','SC-100','Stoneware Clay'),
						   ('R5','S2','SR-100','Sandstone'),
						   ('R3','S2','NS-100','Natural Sand'),
						   ('R2','S2','THW-100','Teak'),
						   ('R5','S2','OPC-100','OPC'),
						   
						   ('R1','S3','EC-100','Earthenware Clay'),
						   ('R2','S3','LR-100','Limestone'),
						   ('R3','S3','US-100','Utility Sand'),
						   ('R4','S3','PSW-100','Pine'),
						   ('R5','S3','OPC-100','OPC'),
						   
						   ('R1','S4','BC-100','Brick Clay'),
						   ('R2','S4','GR-100','Granite'),
						   ('R3','S4','CS-100','Concrete Sand'),
						   ('R4','S4','ASW-100','Ash'),
						   ('R5','S4','OPC-100','OPC'),
						   
						   ('R1','S5','SC-100','Stoneware Clay'),
						   ('R5','S5','SR-100','Sandstone'),
						   ('R3','S5','NS-100','Natural Sand'),
						   ('R4','S5','OHW-100','Oak'),
						   ('R5','S5','OPC-100','OPC'),
						   
						   ('R1','S6','EC-100','Earthenware Clay'),
						   ('R2','S6','LR-100','Limestone'),
						   ('R3','S6','US-100','Utility Sand'),
						   ('R4','S6','THW-100','Teak'),
						   ('R5','S6','OPC-100','OPC'),
						   
						   ('R1','S7','BC-100','Brick Clay'),
						   ('R2','S7','GR-100','Granite'),
						   ('R1','S7','CS-100','Concrete Sand'),
						   ('R4','S7','PSW-100','Pine'),
						   ('R5','S7','OPC-100','OPC');

create table Works_in (
	builder_id varchar(10),
	group_number varchar(10),
	primary key(builder_id,group_number),
	foreign key(builder_id) references Builder(id),
	foreign key(group_number) references Groups(number)
);

insert into Works_in values('B1','G1'),
						   ('B2','G1'),
						   ('B3','G1'),
						   ('B4','G2'),
						   ('B5','G2'),
						   ('B6','G2'),
						   ('B7','G3'),
						   ('B8','G3'),
						   ('B9','G3'),
						   ('B10','G4'),
						   ('B11','G4'),
						   ('B12','G4'),
						   ('B1','G5'),
						   ('B2','G5'),
						   ('B3','G5'),
						   ('B4','G5'),
						   ('B5','G6'),
						   ('B6','G6'),
						   ('B7','G6'),
						   ('B8','G6');
						   
create table Works_on (
	builder_id varchar(10),
	project_no varchar(10),
	hours int,
	primary key(builder_id,project_no),
	foreign key(builder_id) references Builder(id),
	foreign key(project_no) references Project(number)
);

insert into Works_on values('B1','P1',5),
						   ('B2','P1',6),
						   ('B3','P1',7),
						   ('B4','P2',5),
						   ('B5','P2',6),
						   ('B6','P2',7),
						   ('B7','P3',5),
						   ('B8','P3',6),
						   ('B9','P3',7),
						   ('B10','P4',5),
						   ('B11','P4',6),
						   ('B12','P4',7),
						   ('B1','P5',5),
						   ('B2','P5',6),
						   ('B3','P5',7),
						   ('B4','P5',8),
						   ('B5','P6',5),
						   ('B6','P6',6),
						   ('B7','P6',7),
						   ('B8','P6',8);

create table Subcontracts (
	project_number varchar(10),
	contract_name varchar(10),
	company_name varchar(20),
	contact_number bigint,
	primary key(contract_name),
	foreign key(project_number) references Project(number)
);

insert into Subcontracts values('P1','P1-Machn','MCompany1',9192919291),
							  ('P2','P2-Plumb','PCompany1',9292919291),
							  ('P3','P3-Elect','ECompany1',9392919291),
							  ('P4','P4-Machn','MCompany2',9492919291),
							  ('P5','P5-Elect','ECompany2',9592919291),
							  ('P5','P5-Plumb','PCompany1',9692919291),
							  ('P6','P6-Machn','MCompany3',9792919291),
							  ('P6','P6-Plumb','PCompany1',9892919291),
							  ('P6','P6-Elect','ECompany1',9992919291);


create table Machinery (
	contract_name varchar(10),
	type varchar(20),
	contract_duration int,
	expected_budget numeric(10,2),
	capacity varchar,
	primary key(contract_name),
	foreign key(contract_name) references Subcontracts(contract_name)
);

insert into Machinery values('P1-Machn','Excavators',2,50000.00,'270HP'),
							('P4-Machn','Trenchers',1,80000.00,'2000HP'),
							('P6-Machn','Loaders',2,70000.00,'260HP');

create table Plumbing (
	contract_name varchar(10),
	type varchar(20),
	contract_duration int,
	expected_budget numeric(10,2),
	total_pipes_length varchar,
	primary key(contract_name),
	foreign key(contract_name) references Subcontracts(contract_name)
);

insert into Plumbing values('P2-Plumb','New Drains',1,40000.00,'5KM'),
						   ('P5-Plumb','Gasfitters',2,30000.00,'2KM');

create table Electrical (
	contract_name varchar(10),
	type varchar(20),
	contract_duration int,
	expected_budget numeric(10,2),
	total_wiring_length varchar,
	primary key(contract_name),
	foreign key(contract_name) references Subcontracts(contract_name)
);
						   
insert into Electrical values('P3-Elect','Wiring',1,10000.00,'25KM'),
							 ('P5-Elect','Fuse Work',1,20000.00,'5KM'),
							 ('P6-Elect','Generator',1,70000.00,'15KM');
							 
							 
							 
							 
							 
/*DROP table builder,client,client_emails,client_phone_numbers,electrical,groups,machinery,plumbing,project,raw_materials,
retailer,retailer_material,site,subcontracts,supplies,works_on,works_in;			 
							 
DROP table Builder,Client;	*/		 
					
1) SELECT * FROM Builder,Groups WHERE passcode=crypt('Atharv123',passcode) AND Groups.manager_id='B1' AND id = 'B1'; /* manager login*/
2) SELECT distinct A.id FROM Builder A, Builder B WHERE A.passcode=crypt('Bhasker123',A.passcode) AND A.id=B.supervisor_id AND A.id = 'B3';


