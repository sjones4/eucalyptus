# Makefile for Eucalyptus Node Controller
#
# Copyright 2009-2012 Ent. Services Development Corporation LP
#
# Redistribution and use of this software in source and binary forms,
# with or without modification, are permitted provided that the
# following conditions are met:
#
#   Redistributions of source code must retain the above copyright
#   notice, this list of conditions and the following disclaimer.
#
#   Redistributions in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer
#   in the documentation and/or other materials provided with the
#   distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.
#
# This file may incorporate work covered under the following copyright
# and permission notice:
#
#   Software License Agreement (BSD License)
#
#   Copyright (c) 2008, Regents of the University of California
#   All rights reserved.
#
#   Redistribution and use of this software in source and binary forms,
#   with or without modification, are permitted provided that the
#   following conditions are met:
#
#     Redistributions of source code must retain the above copyright
#     notice, this list of conditions and the following disclaimer.
#
#     Redistributions in binary form must reproduce the above copyright
#     notice, this list of conditions and the following disclaimer
#     in the documentation and/or other materials provided with the
#     distribution.
#
#   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
#   "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
#   LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
#   FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
#   COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
#   INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
#   BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
#   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
#   CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
#   LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
#   ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
#   POSSIBILITY OF SUCH DAMAGE. USERS OF THIS SOFTWARE ACKNOWLEDGE
#   THE POSSIBLE PRESENCE OF OTHER OPEN SOURCE LICENSED MATERIAL,
#   COPYRIGHTED MATERIAL OR PATENTED MATERIAL IN THIS SOFTWARE,
#   AND IF ANY SUCH MATERIAL IS DISCOVERED THE PARTY DISCOVERING
#   IT MAY INFORM DR. RICH WOLSKI AT THE UNIVERSITY OF CALIFORNIA,
#   SANTA BARBARA WHO WILL THEN ASCERTAIN THE MOST APPROPRIATE REMEDY,
#   WHICH IN THE REGENTS' DISCRETION MAY INCLUDE, WITHOUT LIMITATION,
#   REPLACEMENT OF THE CODE SO IDENTIFIED, LICENSING OF THE CODE SO
#   IDENTIFIED, OR WITHDRAWAL OF THE CODE CAPABILITY TO THE EXTENT
#   NEEDED TO COMPLY WITH ANY SUCH LICENSES OR RIGHTS.

include ../Makedefs

SUBDIRS=.
WSDLPATH=../wsdl/
CCWSDLNAME=eucalyptus_cc.wsdl
CCWSDL=$(WSDLPATH)/$(CCWSDLNAME)
NCWSDLNAME=eucalyptus_nc.wsdl
NCWSDL=$(WSDLPATH)/$(NCWSDLNAME)
SCWSDLNAME=eucalyptus_sc.wsdl
SCWSDL=$(WSDLPATH)/$(SCWSDLNAME)
SERVICE_NAME=EucalyptusNC
CLIENT=NCclient
GFLAGS=$(patsubst -Werror,,$(CFLAGS))
GPPFLAGS=$(patsubst -Werror,,$(CPPFLAGS))
NC_LIBS	= $(LIBS) $(LDFLAGS) -lvirt -lcurl -lssl -lcrypto `xslt-config --libs`
OPENSSL_LIBS = -lssl -lcrypto
NET_LIB = ../net/libeucanet.a
NC_HANDLERS=handlers_xen.o handlers_kvm.o handlers_default.o xml.o hooks.o
STORAGE_OBJS=../storage/backing.o ../storage/diskutil.o ../storage/blobstore.o ../storage/objectstorage.o ../storage/vbr.o ../storage/iscsi.o ../storage/ebs_utils.o ../storage/storage-controller.o
STATS_OBJS = ../util/stats/stats.o ../util/stats/sensor_common.o ../util/stats/message_sensor.o ../util/stats/service_sensor.o ../util/stats/fs_emitter.o ../util/stats/message_stats.o
STATS_LIBS = -ljson-c -lm
AR      := /usr/bin/ar
ARFLAGS := -cq
CFLAGS +=

# The Eucalyptus Node Library
LIBNODE       := handlers
LIBNODEOBJS   := $(LIBNODE:=.o) $(STORAGE_OBJS) $(STATS_OBJS) $(NC_HANDLERS) ../util/config.o ../util/log.o ../util/misc.o ../util/euca_file.o ../util/euca_string.o ../util/euca_system.o ../util/euca_network.o ../util/sensor.o ../util/fault.o ../util/utf8.o ../util/wc.o ../util/hash.o ../util/data.o ../util/eucalyptus.h ../util/euca_auth.o ../util/ipc.o ../net/euca_gni.o ../net/eucanetd_util.o ../storage/http.o ../storage/storage-windows.o
LIBNODEDEPS   := $(LIBNODEOBJS) $(NET_LIB)
LIBNODENAME   := libeucanode.a

BUILD_ID=-DEUCA_COMPILE_TIMESTAMP=\""[built `date --rfc-3339='sec'`]"\"

all: $(LIBNODENAME)
	@for subdir in $(SUBDIRS); do \
		(cd $$subdir && $(MAKE) buildall) || exit $$? ; done

build: all

buildall: $(LIBNODENAME)

$(LIBNODENAME): $(LIBNODEDEPS)
	$(AR) $(ARFLAGS) $@ $(LIBNODEOBJS)

.c.o:
	$(CC) -c $(BUILD_ID) $(CPPFLAGS) $(CFLAGS) `xslt-config --cflags` $(INCLUDES) $<

server: $(SCLIBS) $(NET_LIB) $(LIBNODENAME)

../storage/backing.o: ../storage/backing.c ../util/log.o ../util/misc.o ../util/euca_string.o ../util/euca_file.o ../util/data.o
	make -C ../storage

../storage/diskutil.o: ../storage/diskutil.c ../util/log.o ../util/misc.o ../util/euca_string.o ../util/euca_file.o ../util/data.o
	make -C ../storage

../storage/blobstore.o: ../storage/blobstore.c ../util/log.o ../util/misc.o ../util/euca_string.o ../util/euca_file.o ../util/data.o
	make -C ../storage

../storage/objectstorage.o: ../storage/objectstorage.c ../util/log.o ../util/misc.o ../util/euca_string.o ../util/euca_file.o ../util/data.o
	make -C ../storage

../storage/iscsi.o: ../storage/iscsi.c
	make -C ../storage

../storage/http.o: ../storage/http.c ../util/log.o ../util/misc.o ../util/euca_string.o ../util/euca_file.o ../util/data.o
	make -C ../storage

../storage/vbr.o: ../storage/vbr.c ../util/data.o
	make -C ../storage

../util/misc.o: ../util/misc.c ../util/misc.h ../util/eucalyptus.h
	make -C ../util

../util/euca_string.o: ../util/euca_string.c ../util/euca_string.h ../util/eucalyptus.h
	make -C ../util

../util/euca_file.o: ../util/euca_file.c ../util/euca_file.h ../util/eucalyptus.h
	make -C ../util

../util/log.o: ../util/log.c ../util/eucalyptus.h
	make -C ../util

../util/data.o: ../util/data.c ../util/data.h ../util/eucalyptus.h
	make -C ../util

../util/euca_auth.o: ../util/euca_auth.c ../util/data.h ../util/eucalyptus.h
	make -C ../util

../util/euca_system.o: ../util/euca_system.c ../util/euca_system.h ../util/eucalyptus.h
	make -C ../util

../util/sensor.o: ../util/sensor.c
	make -C ../util

../storage/ebs_utils.o: ../storage/ebs_utils.c
	make -C ../storage

../storage/storage-controller.o: ../storage/storage-controller.c
	make -C ../storage

$(NET_LIB):
	make -C ../net

../util/stats/%.o:
	make -C ../util/stats

indent:
	@for idfile in *.[ch]; do \
		echo $(INDENTTOOLS) $$idfile $(INDENTFLAGS) -o $$idfile ; \
		$(INDENTTOOLS) $$idfile $(INDENTFLAGS) -o $$idfile ; \
	done

clean:
	rm -rf *.o $(CLIENT) $(CLIENT)_local $(NET_LIB) *~* *#* test_nc test_misc test_xml test_xml2

distclean:
	rm -rf *.o $(CLIENT) $(CLIENT)_local nc-client-policy.xml test test_nc test_hooks $(NET_LIB) *~* *#*

install: deploy
	$(INSTALL) -m 0700 -d $(DESTDIR)$(libvirthooksdir)
	$(INSTALL) -d $(DESTDIR)$(policiesdir)
	$(INSTALL) nc-client-policy.xml $(DESTDIR)$(policiesdir)
	$(INSTALL) -m 0755 test_nc $(DESTDIR)$(sbindir)/euca_test_nc
	$(INSTALL) -m 0755 eucalyptus-node $(DESTDIR)$(sbindir)/eucalyptus-node
	$(INSTALL) -m 0700 libvirt-hooks/qemu $(DESTDIR)$(libvirthooksdir)/qemu

uninstall:
	$(RM) -f $(DESTDIR)$(policiesdir)/nc-client-policy.xml
	$(RM) -f $(DESTDIR)$(sbindir)/euca_test_nc
	$(RM) -f $(libvirthooksdir)/qemu

