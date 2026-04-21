-- Kutuphane Yonetim Sistemi --
-- Varliklar: Kitap, Ogrenci, Gorevli, OduncAlma, Iade, Ceza --

-- CREATE DATABASE kutuphane_db

-- TABLOLAR --

CREATE TABLE kitap(
	id SERIAL PRIMARY KEY,
    kitap_adi VARCHAR(100) NOT NULL,
    yazar VARCHAR(100) NOT NULL,
    kategori VARCHAR(50) NOT NULL,
	stok_adedi INT NOT NULL CHECK (stok_adedi>=0),
	raf_no VARCHAR(20),
	durum VARCHAR(20) NOT NULL DEFAULT 'Mevcut' CHECK (durum IN ('Mevcut', 'OduncVerildi', 'Kayip', 'Hasarli'))
);

CREATE TABLE ogrenci (
    id SERIAL PRIMARY KEY,
    okul_no VARCHAR(20) UNIQUE NOT NULL,
    ad VARCHAR(50) NOT NULL,
    soyad VARCHAR(50) NOT NULL,
    telefon VARCHAR(20),
	kayit_tarihi TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	durum VARCHAR(20) NOT NULL DEFAULT 'Aktif' CHECK (durum IN ('Aktif', 'Pasif', 'Mezun'))
);


CREATE TABLE gorevli (
    id SERIAL PRIMARY KEY,
    tc_no VARCHAR(11) UNIQUE NOT NULL,
    ad VARCHAR(50) NOT NULL,
    soyad VARCHAR(50) NOT NULL,
    telefon VARCHAR(20),
    vardiya VARCHAR(20) CHECK (vardiya IN ('Sabah', 'Aksam', 'TamGun'))
);

CREATE TABLE odunc_alma (
    id SERIAL PRIMARY KEY,
    kitap_id INT NOT NULL,
    ogrenci_id INT NOT NULL,
    gorevli_id INT NOT NULL,
    odunc_tarihi DATE NOT NULL DEFAULT CURRENT_DATE,
    son_teslim_tarihi DATE NOT NULL,
    durum VARCHAR(20) NOT NULL DEFAULT 'Oduncte' CHECK (durum IN ('Oduncte', 'TeslimEdildi', 'Gecikti')),
    CONSTRAINT fk_odunc_kitap FOREIGN KEY (kitap_id) REFERENCES kitap(id),
    CONSTRAINT fk_odunc_ogrenci FOREIGN KEY (ogrenci_id) REFERENCES ogrenci(id),
    CONSTRAINT fk_odunc_gorevli FOREIGN KEY (gorevli_id) REFERENCES gorevli(id),
    CONSTRAINT chk_teslim_tarihi CHECK (son_teslim_tarihi >= odunc_tarihi)
);


CREATE TABLE iade (
    id SERIAL PRIMARY KEY,
    odunc_id INT NOT NULL UNIQUE,
    iade_tarihi DATE NOT NULL,
    teslim_alan_gorevli_id INT NOT NULL,
    kitap_durumu VARCHAR(20) NOT NULL CHECK (kitap_durumu IN ('Saglam', 'Hasarli', 'Kayip')),
    aciklama VARCHAR(255),
    CONSTRAINT fk_iade_odunc FOREIGN KEY (odunc_id) REFERENCES odunc_alma(id),
    CONSTRAINT fk_iade_gorevli FOREIGN KEY (teslim_alan_gorevli_id) REFERENCES gorevli(id)
);


CREATE TABLE ceza (
    ceza_id SERIAL PRIMARY KEY,
    odunc_id INT NOT NULL,
    ogrenci_id INT NOT NULL,
    ceza_turu VARCHAR(30) NOT NULL CHECK (ceza_turu IN ('GecTeslim', 'Hasar', 'Kayip')),
    ceza_tutari NUMERIC(10,2) NOT NULL CHECK (ceza_tutari >= 0),
    ceza_tarihi DATE NOT NULL DEFAULT CURRENT_DATE,
    odeme_durumu VARCHAR(20) NOT NULL DEFAULT 'Odenmedi' CHECK (odeme_durumu IN ('Odendi', 'Odenmedi')),
    aciklama VARCHAR(255),
    CONSTRAINT fk_ceza_odunc FOREIGN KEY (odunc_id) REFERENCES odunc_alma(id),
    CONSTRAINT fk_ceza_ogrenci FOREIGN KEY (ogrenci_id) REFERENCES ogrenci(id)
);


-- DML Komutları ---

-- KITAPLAR
INSERT INTO kitap ( kitap_adi, yazar, kategori, stok_adedi, raf_no, durum) VALUES
('Tutunamayanlar', 'Oğuz Atay', 'Roman', 4, 'A-101', 'Mevcut'),
('İnce Memed', 'Yaşar Kemal', 'Roman', 3, 'A-102', 'Mevcut'),
( 'Suç ve Ceza', 'Fyodor Dostoyevski', 'Klasik', 5, 'B-201', 'Mevcut'),
( 'Simyacı', 'Paulo Coelho', 'Roman', 6, 'B-202', 'Mevcut'),
('1984', 'George Orwell',  'Distopya', 2, 'C-301', 'OduncVerildi');

-- OGRENCI 
INSERT INTO ogrenci (okul_no, ad, soyad, telefon,kayit_tarihi, durum) VALUES
('2023001', 'Ahmet', 'Yılmaz', '05001112233', '2024-09-15', 'Aktif'),
('2023002', 'Ayşe', 'Kara',  '05002223344', '2024-09-16', 'Aktif'),
('2023003', 'Mehmet', 'Demir', '05003334455', '2024-09-17', 'Aktif'),
('2023004', 'Zeynep', 'Çelik',  '05004445566', '2024-09-18', 'Aktif'),
('2023005', 'Elif', 'Aydın', '05005556677', '2024-09-19', 'Aktif');

INSERT INTO ogrenci (okul_no, ad, soyad, telefon, durum) VALUES
('2023009', 'Umut', 'Ay', '05005556611',  'Aktif');


-- GOREVLI

INSERT INTO gorevli (tc_no, ad, soyad, telefon, vardiya) VALUES
('11111111111', 'Selim', 'Arslan', '05321110001', 'Sabah'),
('22222222222', 'Merve', 'Koç', '05321110002','TamGun'),
('33333333333', 'Can', 'Şahin','05321110003','Aksam'),
('44444444444', 'Buse', 'Aksoy','05321110004','Sabah'),
('55555555555', 'Emre', 'Taş', '05321110005','TamGun');


-- ODUNC_ALMA
INSERT INTO odunc_alma (kitap_id, ogrenci_id, gorevli_id, odunc_tarihi, son_teslim_tarihi, durum) VALUES
(1, 1, 1, '2026-04-01', '2026-04-15', 'TeslimEdildi'),
(2, 2, 2, '2026-04-03', '2026-04-17', 'TeslimEdildi'),
(3, 3, 3, '2026-04-05', '2026-04-19', 'Gecikti'),
(4, 4, 4, '2026-04-06', '2026-04-20', 'TeslimEdildi'),
(5, 5, 5, '2026-04-10', '2026-04-24', 'Oduncte');


-- IADE
INSERT INTO iade (odunc_id, iade_tarihi, teslim_alan_gorevli_id, kitap_durumu, aciklama) VALUES
(1, '2026-04-14', 2, 'Saglam', 'Zamanında teslim edildi.'),
(2, '2026-04-16', 1, 'Saglam', 'Kitap temiz durumda teslim edildi.'),
(3, '2026-04-22', 3, 'Hasarli', 'Kitabın kapağında yıpranma var.'),
(4, '2026-04-19', 4, 'Saglam', 'Teslim işlemi sorunsuz tamamlandı.'),
(5, '2026-04-25', 5, 'Saglam', 'Bir gün gecikmeli teslim edildi.');

-- CEZA 
INSERT INTO ceza (odunc_id, ogrenci_id, ceza_turu, ceza_tutari, ceza_tarihi, odeme_durumu, aciklama) VALUES
(1, 1, 'GecTeslim', 15.00, '2026-04-15', 'Odendi', '1 gün gecikme cezası.'),
(2, 2, 'GecTeslim', 10.00, '2026-04-17', 'Odendi', 'Teslim saati aşıldığı için ceza.'),
(3, 3, 'Hasar', 50.00, '2026-04-22', 'Odenmedi', 'Kapak hasarı nedeniyle ceza kesildi.'),
(4, 4, 'GecTeslim', 5.00, '2026-04-20', 'Odendi', 'Kısa süreli gecikme.'),
(5, 5, 'GecTeslim', 20.00, '2026-04-25', 'Odenmedi', 'Teslim tarihi geçildi.');


UPDATE kitap SET stok_adedi = 7 WHERE id = 4;
UPDATE ogrenci SET telefon = '05009998877' WHERE id = 2;

SELECT * FROM kitap;
SELECT * FROM ceza WHERE odeme_durumu = 'Odenmedi';
SELECT kitap_adi, yazar FROM kitap WHERE kategori = 'Roman';



