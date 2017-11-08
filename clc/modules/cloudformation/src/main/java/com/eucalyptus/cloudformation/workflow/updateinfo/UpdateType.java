/*************************************************************************
 * Copyright 2009-2014 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.cloudformation.workflow.updateinfo;

/**
 * Created by ethomas on 12/11/15.
 */
public enum UpdateType {
  NONE,
  NO_INTERRUPTION,
  SOME_INTERRUPTION,
  NEEDS_REPLACEMENT,
  UNSUPPORTED;

  public static UpdateType max(UpdateType u1, UpdateType u2) {
    if (u1 == UNSUPPORTED || u2 == UNSUPPORTED) return UNSUPPORTED;
    if (u1 == NEEDS_REPLACEMENT || u2 == NEEDS_REPLACEMENT) return NEEDS_REPLACEMENT;
    if (u1 == SOME_INTERRUPTION || u2 == SOME_INTERRUPTION) return SOME_INTERRUPTION;
    if (u1 == NO_INTERRUPTION || u2 == NO_INTERRUPTION) return NO_INTERRUPTION;
    return NONE;
  }
}
