--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: justinfokes
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    phone character varying,
    requesteddate character varying,
    clientrequests character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO justinfokes;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: justinfokes
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO justinfokes;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: justinfokes
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: justinfokes
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    phone character varying,
    location character varying
);


ALTER TABLE stylists OWNER TO justinfokes;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: justinfokes
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO justinfokes;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: justinfokes
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: justinfokes
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: justinfokes
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: justinfokes
--

COPY clients (id, name, phone, requesteddate, clientrequests, stylistid) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: justinfokes
--

SELECT pg_catalog.setval('clients_id_seq', 34, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: justinfokes
--

COPY stylists (id, name, phone, location) FROM stdin;
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: justinfokes
--

SELECT pg_catalog.setval('stylists_id_seq', 60, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: justinfokes
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: justinfokes
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: justinfokes
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM justinfokes;
GRANT ALL ON SCHEMA public TO justinfokes;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

