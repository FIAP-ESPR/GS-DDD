-- Criação das sequências
CREATE SEQUENCE locations_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE current_weather_data_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE weather_condition_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE minutely_weather_data_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE hourly_weather_data_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE daily_weather_data_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE daily_temperature_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE daily_feels_like_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE weather_alert_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Criação das tabelas

CREATE TABLE locations (
    id NUMBER(19) DEFAULT locations_seq.NEXTVAL PRIMARY KEY,
    latitude NUMBER(10,6) NOT NULL,
    longitude NUMBER(10,6) NOT NULL,
    city_name VARCHAR2(255) NOT NULL,
    state_code VARCHAR2(255) NOT NULL,
    country_code VARCHAR2(255) NOT NULL,
    timezone VARCHAR2(255) NOT NULL,
    timezone_offset NUMBER(10) NOT NULL,
    last_updated TIMESTAMP
);

CREATE UNIQUE INDEX idx_location_lat_lon ON locations (latitude, longitude);

CREATE TABLE current_weather_data (
    id NUMBER(19) DEFAULT current_weather_data_seq.NEXTVAL PRIMARY KEY,
    location_id NUMBER(19) NOT NULL,
    dt NUMBER(19) NOT NULL,
    sunrise NUMBER(19),
    sunset NUMBER(19),
    temp NUMBER(10,2),
    feels_like NUMBER(10,2),
    pressure NUMBER(10),
    humidity NUMBER(10),
    dew_point NUMBER(10,2),
    uvi NUMBER(10,2),
    clouds NUMBER(10),
    visibility NUMBER(10),
    wind_speed NUMBER(10,2),
    wind_deg NUMBER(10),
    wind_gust NUMBER(10,2),
    CONSTRAINT fk_current_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE weather_condition (
    id NUMBER(19) DEFAULT weather_condition_seq.NEXTVAL PRIMARY KEY,
    condition_id NUMBER(10) NOT NULL,
    main VARCHAR2(255),
    description VARCHAR2(255),
    icon VARCHAR2(255),
    current_weather_data_id NUMBER(19),
    hourly_weather_data_id NUMBER(19),
    daily_weather_data_id NUMBER(19),
    CONSTRAINT fk_condition_current FOREIGN KEY (current_weather_data_id) REFERENCES current_weather_data(id),
    CONSTRAINT fk_condition_hourly FOREIGN KEY (hourly_weather_data_id) REFERENCES hourly_weather_data(id),
    CONSTRAINT fk_condition_daily FOREIGN KEY (daily_weather_data_id) REFERENCES daily_weather_data(id)
);

CREATE TABLE minutely_weather_data (
    id NUMBER(19) DEFAULT minutely_weather_data_seq.NEXTVAL PRIMARY KEY,
    location_id NUMBER(19) NOT NULL,
    dt NUMBER(19) NOT NULL,
    precipitation NUMBER(10,2),
    CONSTRAINT fk_minutely_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE hourly_weather_data (
    id NUMBER(19) DEFAULT hourly_weather_data_seq.NEXTVAL PRIMARY KEY,
    location_id NUMBER(19) NOT NULL,
    dt NUMBER(19) NOT NULL,
    temp NUMBER(10,2),
    feels_like NUMBER(10,2),
    pressure NUMBER(10),
    humidity NUMBER(10),
    dew_point NUMBER(10,2),
    uvi NUMBER(10,2),
    clouds NUMBER(10),
    visibility NUMBER(10),
    wind_speed NUMBER(10,2),
    wind_deg NUMBER(10),
    wind_gust NUMBER(10,2),
    pop NUMBER(10,2),
    CONSTRAINT fk_hourly_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE daily_weather_data (
    id NUMBER(19) DEFAULT daily_weather_data_seq.NEXTVAL PRIMARY KEY,
    location_id NUMBER(19) NOT NULL,
    dt NUMBER(19) NOT NULL,
    sunrise NUMBER(19),
    sunset NUMBER(19),
    moonrise NUMBER(19),
    moonset NUMBER(19),
    moon_phase NUMBER(10,2),
    summary VARCHAR2(255),
    pressure NUMBER(10),
    humidity NUMBER(10),
    dew_point NUMBER(10,2),
    wind_speed NUMBER(10,2),
    wind_deg NUMBER(10),
    wind_gust NUMBER(10,2),
    clouds NUMBER(10),
    pop NUMBER(10,2),
    rain NUMBER(10,2),
    uvi NUMBER(10,2),
    CONSTRAINT fk_daily_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE daily_temperature (
    id NUMBER(19) DEFAULT daily_temperature_seq.NEXTVAL PRIMARY KEY,
    daily_weather_data_id NUMBER(19) NOT NULL,
    morn NUMBER(10,2),
    day NUMBER(10,2),
    eve NUMBER(10,2),
    night NUMBER(10,2),
    min NUMBER(10,2),
    max NUMBER(10,2),
    CONSTRAINT fk_daily_temp FOREIGN KEY (daily_weather_data_id) REFERENCES daily_weather_data(id)
);

CREATE TABLE daily_feels_like (
    id NUMBER(19) DEFAULT daily_feels_like_seq.NEXTVAL PRIMARY KEY,
    daily_weather_data_id NUMBER(19) NOT NULL,
    morn NUMBER(10,2),
    day NUMBER(10,2),
    eve NUMBER(10,2),
    night NUMBER(10,2),
    CONSTRAINT fk_daily_feels FOREIGN KEY (daily_weather_data_id) REFERENCES daily_weather_data(id)
);

CREATE TABLE weather_alert (
    id NUMBER(19) DEFAULT weather_alert_seq.NEXTVAL PRIMARY KEY,
    location_id NUMBER(19) NOT NULL,
    sender_name VARCHAR2(255),
    event VARCHAR2(255),
    start_time NUMBER(19),
    end_time NUMBER(19),
    description VARCHAR2(255),
    CONSTRAINT fk_alert_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE weather_alert_tags (
    weather_alert_id NUMBER(19) NOT NULL,
    tag VARCHAR2(255) NOT NULL,
    CONSTRAINT fk_alert_tags FOREIGN KEY (weather_alert_id) REFERENCES weather_alert(id)
);


