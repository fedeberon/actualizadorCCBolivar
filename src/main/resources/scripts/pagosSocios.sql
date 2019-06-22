USE [soccam]
GO

/****** Object:  Table [dbo].[pagosSocios]    Script Date: 12/06/2019 05:04:53 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pagosSocios](
	[pagosSocios_id] [bigint] IDENTITY(1,1) NOT NULL,
	[pagosSocios_socio] [bigint] NULL,
	[pagosSocios_plan] [bigint] NULL,
	[pagosSocios_anio] [int] NULL,
	[pagosSocios_periodo] [int] NULL,
	[pagosSocios_periodicidad] [int] NULL,
	[pagosSocios_fechaVencimiento] [date] NULL,
	[pagosSocios_fechaPago] [date] NULL,
	[pagosSocios_observaciones] [nvarchar](150) NULL,
	[pagosSocios_estado] [int] NULL,
	[pagosSocios_cobrador] [bigint] NULL,
	[pagosSocios_monto] [decimal](25, 13) NULL,
	[pagosSocios_deleted] [bit] NULL,
	[pagosSocios_modificado] [datetime] NULL,
	[pagosSocios_crx_fechaVencimiento] [bigint] NULL,
	[pagosSocios_crx_fechaPago] [bigint] NULL,
	[pagosSocios_operacion] [bigint] NULL CONSTRAINT [DF_pagosSocios_pagosSocios_operacion]  DEFAULT ((0)),
 CONSTRAINT [PK_pagosSocios] PRIMARY KEY CLUSTERED 
(
	[pagosSocios_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


